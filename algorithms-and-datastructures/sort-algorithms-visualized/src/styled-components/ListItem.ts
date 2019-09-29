import styled from 'styled-components';

interface Props {
    width: number,
}

const ListItem = styled.div`
    width: ${(props: Props) => props.width}%;
    background: hsl(${(props: Props) => props.width / 100 * 255}, 100%, 50%);
    padding: 10px 20px;
    margin: 5px 0;
    border-radius: 4px;
`;

export default ListItem;